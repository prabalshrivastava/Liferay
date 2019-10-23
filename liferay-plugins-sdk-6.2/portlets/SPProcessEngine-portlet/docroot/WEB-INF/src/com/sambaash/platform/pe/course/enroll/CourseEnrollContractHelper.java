package com.sambaash.platform.pe.course.enroll;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.SystemProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants.EXCEL;
import com.sambaash.platform.exception.FileFormatException;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEHelper;
import com.sambaash.platform.pe.jaxb.PEConfig;
import com.sambaash.platform.srv.model.Certificate;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.CourseCertificate;
import com.sambaash.platform.srv.model.CourseEnrollContract;
import com.sambaash.platform.srv.model.CourseModule;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.model.Framework;
import com.sambaash.platform.srv.model.MiscellaneousFees;
import com.sambaash.platform.srv.model.Module;
import com.sambaash.platform.srv.model.ModuleFramework;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.model.StudentCourseFee;
import com.sambaash.platform.srv.model.StudentCourseFeeInstmnt;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.service.CertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseCertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseEnrollContractLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.FrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.MiscellaneousFeesLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleFrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.srv.service.StudentCourseFeeInstmntLocalServiceUtil;
import com.sambaash.platform.srv.service.StudentCourseFeeLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class CourseEnrollContractHelper {
	
	private PEDataSource dataSource;
	private PEProcessState processState;
	
	private List<CourseEnrollContract> contracts;
	
	private Course course;
	private Product product;
	
	// this dataamp contains fixed key/values irrespective of contract 
	private Map<String,String> fixedDataMap;
	
	
	private CourseEnrollContractHelper(PEDataSource dataSource) throws SystemException, PortalException, PEException{
		this.dataSource = dataSource;
		
		processState = dataSource.getProcessState();
		product = ProductLocalServiceUtil.getProduct(processState.getEntityId());
		course = CourseLocalServiceUtil.getCourse(product.getSpCourseId());
		
		contracts = CourseEnrollContractLocalServiceUtil.findByCountryIdCourseType(String.valueOf(course.getCountryId()), course.getCourseType());
		_log.debug("Contract docs size " + contracts.size());
		if(contracts.size() == 0){
			_log.error("Contract template not found Country Id = " + String.valueOf(course.getCountryId()) + "Course Type = " + course.getCourseType());
			throw new PEException("Contract Template does not exist");
		}
		prepareFixedDataMap();
	}

	public static CourseEnrollContractHelper getContractHelper(PEDataSource dataSource) throws  SystemException, PortalException, PEException{
		return new CourseEnrollContractHelper(dataSource);
	}
	 
	public List<CourseEnrollContract> getContractTemplates() throws PEException{
		return contracts;
	}
	
	private void prepareFixedDataMap()  throws PEException{
		String NOT_APPLICABLE = "N.A.";
		
		fixedDataMap = new LinkedHashMap<String, String>();
	
		//fixedDataMap.put("studentFullName",dataSource.getFullNameApplicant());
		fixedDataMap.put("courseTitle", course.getCourseName());
		
		/*_log.debug("Getting certificate");
		Certificate certificate;
		try {
			// Getting Certificate
			List<CourseCertificate> mcList = CourseCertificateLocalServiceUtil
					.findByCourseIdAndGroupId(course.getSpCourseId(),
							course.getGroupId());
			if(mcList.isEmpty()){
				fixedDataMap.put("certificateName", NOT_APPLICABLE);
			}else{
			certificate = CertificateLocalServiceUtil.getCertificate(mcList
					.get(0).getSpCertificatetId());
				fixedDataMap.put("certificateName",certificate.getTitle());
			}
		} catch (Exception e) {
			_log.error("Error while getting certificate ",e);
			//throw new PEException("Error while getting certificate information");
		}*/
		
		// As per JIRA LHSUPPORT-490, we are replacing the certificate name with course name
		fixedDataMap.put("certificateName", course.getCourseName());
				
		_log.debug("Getting course developer");
		try {
			String courseDeveloper = AssetCategoryLocalServiceUtil.getAssetCategory(course.getCourseDeveloperId()).getName();
			fixedDataMap.put("orgDevelopsCourse",courseDeveloper);
		} catch (Exception e) {
			 _log.error("Error while getting course developer ",e);
		}
		
		_log.debug("Getting awarding body");
		// Awardingbody name
		String awardingBodyName=StringPool.BLANK;
		try {
			awardingBodyName = AssetCategoryLocalServiceUtil.getAssetCategory(course.getAwardingBodyId()).getName();
		} catch (PortalException | SystemException e) {
			_log.error(e);
		//	throw new PEException("Error while getting awarding body name");
		}
		if(Validator.isNull(awardingBodyName)){
			fixedDataMap.put("orgAwardsQualification", "");
		}else{
			fixedDataMap.put("orgAwardsQualification",awardingBodyName);
		}
		String reqs = HtmlUtil.stripHtml(GetterUtil.getString(course.getPersonaDesc()));
		reqs = reqs.replaceAll("&nbsp;", StringPool.SPACE);
		reqs = reqs.replaceAll("[\u2022,\u2023,\u25E6,\u2043,\u2219,\u00B7]", StringPool.BLANK);
		fixedDataMap.put("courseEntryRequirements",reqs);
		
		try {
			_log.debug("Getting Fee details");
			List<StudentCourseFee>feeList = StudentCourseFeeLocalServiceUtil.findByProcessStateId(processState.getSpPEProcessStateId());
			for (int i = 1 ; i<= feeList.size() ; i++) {
				StudentCourseFee fee = feeList.get(i-1);
				FeeType feetype = FeeTypeLocalServiceUtil.findByFeeType(fee.getFeeType());
				fixedDataMap.put("feeType_" + i, feetype.getFeeTypeName() );
				fixedDataMap.put("feeAmount_" + i, fee.getAmount());
			}
		} catch (Exception e) {
			_log.error("Error while preparing fees data ",e);
		}
		
		if(ProductLocalServiceUtil.isQualificationTypeCourse(course)){
			// Qualification type products only have the installments
			try {
				List<StudentCourseFeeInstmnt>instmnts = StudentCourseFeeInstmntLocalServiceUtil.findByProcessStateId(processState.getSpPEProcessStateId());
				if(instmnts != null && instmnts.size() > 0){
					for(int i = 1 ; i <= instmnts.size() ; i++){
						StudentCourseFeeInstmnt insmnt = instmnts.get(i-1);
						fixedDataMap.put("insmntNum_"+i, getInstmntNumText(insmnt.getInsmntNo()));
						fixedDataMap.put("insmntAmount_"+i, insmnt.getAmount());
						fixedDataMap.put("insmntDate_"+i, PEHelper.getDateStrddMMYYYY(insmnt.getDate()));
					}
					fixedDataMap.put("noOfInstmnts", String.valueOf(instmnts.size()));
				}
			} catch (SystemException e) {
				_log.error("Error while preparing installements data ",e);
			}
		}else{
			fixedDataMap.put("noOfInstmnts", String.valueOf(1));
		}
		
		
		// misc information
		try {
			  List<MiscellaneousFees>miscFeeList = MiscellaneousFeesLocalServiceUtil.findByCourseIdAndGroupId(course.getSpCourseId(), course.getGroupId());
			  for(int i = 1 ; i <= miscFeeList.size() ; i++){
				  MiscellaneousFees miscFee = miscFeeList.get(i-1);
				  
				  FeeType feeType = FeeTypeLocalServiceUtil.getFeeType(miscFee.getMiscFeeType());
				  AssetCategory payableDesc = AssetCategoryLocalServiceUtil.getAssetCategory(miscFee.getPayable());
				  fixedDataMap.put("miscFeeType_" + i, feeType.getFeeTypeName());
				  if(miscFee.getAmount() > 0){
					  fixedDataMap.put("miscFeeAmount_" + i, InFixExpressionEvaluator.getBigDecimalWithRounding(miscFee.getAmount() + "").toPlainString() + " - " + payableDesc.getName());
				  }else{
					  fixedDataMap.put("miscFeeAmount_" + i, payableDesc.getName());
				  }
			  }
		} catch (Exception e) {
			_log.error("Error while preparing miscelleneous inf",e);
		}

		//Currency
		try {
			Country country = CountryServiceUtil.getCountryByName(AssetCategoryLocalServiceUtil
					.getAssetCategory(Long.parseLong(course.getCountryId())).getName().toLowerCase());
			Locale locale = new Locale("", country.getA2());
			String currencyCode = Currency.getInstance(locale).getCurrencyCode();
			fixedDataMap.put("currency", currencyCode);
		} catch (Exception e) {
			_log.error("Exception occured while deriving currency from course country. Setting default currency to SGD.",e);
		}
		
		// Total Course fee payable to Lithan
		try {
			StudentCourseFee totalFee = StudentCourseFeeLocalServiceUtil.findByProcessStateIdFeeType(processState.getSpPEProcessStateId(),CourseEnrollConstants.TOTAL_FEE_PAYABLE_TO_LITHAN);
			fixedDataMap.put("totalCourseFeePayable", totalFee.getAmount());
		} catch (Exception e) {
			_log.error("Error while getting total fee payable to lithan",e);
		}
		//country
		try {
			AssetCategory country = AssetCategoryLocalServiceUtil.getAssetCategory(GetterUtil.getLong(course.getCountryId()));
			fixedDataMap.put("registeredCountry", country.getName());
		} catch (Exception e) {
			_log.error("Error while getting country name",e);
		}
		//Email Address
		fixedDataMap.put("emailAddress", dataSource.getEmailApplicant());
	}
	
	private String getInstmntNumText(int num){
		switch(num){
		case 1: return "1st Installment";
		case 2: return "2nd Installment";
		case 3: return "3rd Installment";
		default : return num + "th Installment";
		}
	}
	
	
	public InputStream getContractInputStream(CourseEnrollContract courseContract) throws PEException, PortalException, SystemException{
		String filePath = generateContract(courseContract);
		
		_log.debug("Contract file is generated form (Contract template + datamap) " + filePath);
		InputStream contractPdf;
		try {
			contractPdf = new  FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			throw new PEException("Contract file is not found");
		}
		return contractPdf;
	}
	public String getContractFilePath(CourseEnrollContract courseContract) throws PEException, PortalException, SystemException{
		String filePath = generateContract(courseContract);
		
	
		return filePath;
	}
	
	public String generateContract(CourseEnrollContract courseContract) throws PEException,PortalException, SystemException{
		//CourseEnrollContract courseContract = getContractTemplateInfo();
		_log.debug("CourseContract " + courseContract);
		
		DLFileEntry contractTemplate;
		
		_log.debug("Loading Contract Template ");
		try {
			 contractTemplate = DLFileEntryLocalServiceUtil.getDLFileEntry(courseContract.getContractTemplateFileEntryId());
		} catch (PortalException | SystemException e) {
			_log.error("Error while getting contract template. ContractTemplate = " + courseContract,e);
			throw new PEException(PEErrors.format(PEErrors.ESIGN_CONTRACT_TEMPLATE_NOT_FOUND_ARGS, courseContract.getContractTemplateFileEntryId()));
		}
	
		DLFileEntry dataTemplate;
		_log.debug("Loading data template");
		try {
			dataTemplate = DLFileEntryLocalServiceUtil.getDLFileEntry(courseContract.getDataTemplateFileEntryId());
		} catch (PortalException | SystemException e) {
			_log.error("Error while getting data template. ContractTemplate = " + courseContract,e);
			throw new PEException(PEErrors.format(PEErrors.ESIGN_DATA_TEMPLATE_NOT_FOUND_ARGS, courseContract.getContractTemplateFileEntryId()));
		}
		
		InputStream dataTemplateIS = dataTemplate.getContentStream();
		InputStream contractTempIS = contractTemplate.getContentStream();
		try {
			_log.debug("Creating workbook object from data template");
			Workbook wb = getWorkBook(dataTemplate.getExtension(), dataTemplateIS);
			
			_log.debug("Call for preparing DataMap.");
			Map<String,String>dataMap = getDataMap(wb.getSheetAt(0));
			
			_log.debug("Call for generating contract file");
			String filePath = generateContract(dataMap, contractTempIS,courseContract.getDocType());
			_log.debug("Contract file is generated form (Contract template + datamap) " + filePath);
			return filePath;
		} catch(Exception e){
			_log.error(e);
			throw new PEException("Error while generating the contract");
		}finally {
			try {
				dataTemplateIS.close();
				contractTempIS.close();
			} catch (IOException e) {
				_log.error(e);;
			}
		}
	}
	
	/**
	 *  Method used to create the datamap (key/value's) required to populate contract template.
	 *  
	 *  ContractTemplate pdf contains placeholder's for filling the data dynamically. Each placeholder has the name.
	 *  
	 *  DataMap key is Placeholder name and value is fetched from either form/product app.
	 * 
	 * @param dataSheet
	 * @return
	 * @throws SystemException
	 * @throws PEException
	 * @throws PortalException
	 */
	private Map<String,String> getDataMap(Sheet dataSheet) throws SystemException, PEException, PortalException{
		CourseEnrollDataAdapter dataAdapter = CourseEnrollDataAdapter.getCourseEnrollAdapter(dataSource);
		
		Map<String,String>dataMap = new HashMap<String,String>();
		String NOT_APPLICABLE = "N.A.";
		String NOT_APPLICABLE_NO_DOTS = "NA";
		for (int i = 1; i <= dataSheet.getLastRowNum(); i++) {
			Row row = dataSheet.getRow(i);
			if(row == null) continue;
			String source = getValueNullSafe(row.getCell(0));
			String fieldId  = getValueNullSafe(row.getCell(1));
			String templatVarName =  getValueNullSafe(row.getCell(2));
			
			if(Validator.isNull(fieldId) || Validator.isNull(templatVarName)){
				continue;
			}
			
			if(fixedDataMap.containsKey(fieldId)){
				dataMap.put(templatVarName, fixedDataMap.get(fieldId));
				continue;
			}

			if("form".equalsIgnoreCase(source)){
				dataMap.put(templatVarName, dataAdapter.getFieldDisplayText(fieldId));
			}else{
				
				String fullNameApplicant = StringPool.BLANK;
				if(Validator.isNull(dataAdapter.getStudentNameInIdentityDoc())){
					 fullNameApplicant = dataSource.getFullNameApplicant();
				 }else{
					 fullNameApplicant = dataAdapter.getStudentNameInIdentityDoc();
				 }
				
				 if("gaurdianFullNameConditional".equalsIgnoreCase(fieldId)){
					 if(dataAdapter.isStudentMinor()){
						 dataMap.put(templatVarName, dataAdapter.getGaurdIanFullName());
					 }else{
						 dataMap.put(templatVarName, NOT_APPLICABLE);
					 }
				 }else if("studentFullName".equalsIgnoreCase(fieldId)){
						 dataMap.put(templatVarName, fullNameApplicant);
				 }else if("studentFullNameConditional".equalsIgnoreCase(fieldId)){
					 if(dataAdapter.isStudentMinor()){
						 dataMap.put(templatVarName, NOT_APPLICABLE);
					 }else{
						 dataMap.put(templatVarName, fullNameApplicant);
					 }
				 }
				 else if("gaurdianIdentityDocNumConditional".equalsIgnoreCase(fieldId)){
					 if(dataAdapter.isStudentMinor()){
						 dataMap.put(templatVarName, dataAdapter.getGaurdIanIdentityDocNum());
					 }else{
						 dataMap.put(templatVarName, NOT_APPLICABLE);
					 }
				 }else  if("courseDuration".equalsIgnoreCase(fieldId)){
					if(Validator.isNull(course.getCourseDurationFullTime())){
						dataMap.put(templatVarName, "");
					}else{
					if(dataAdapter.isFullTime()){
						dataMap.put(templatVarName, course.getCourseDurationFullTime());
					}else{
						dataMap.put(templatVarName, course.getCourseDurationPartTime());
					}
					}
				} else if ("sponsorship".equalsIgnoreCase(fieldId)){
					String sponsorCompany = dataAdapter.getSponsorCompany();
					if(!sponsorCompany.replaceAll("\\.", "").equalsIgnoreCase(NOT_APPLICABLE_NO_DOTS) && dataAdapter.isUploadedSponsorCompanyLetter()){
						dataMap.put(templatVarName, "Yes");
					}else{
						dataMap.put(templatVarName, "No");
					}
				} else if ("sponsorCompanyName".equalsIgnoreCase(fieldId)){
					String sponsorCompany = dataAdapter.getSponsorCompany();
					if(!sponsorCompany.equalsIgnoreCase(NOT_APPLICABLE) && dataAdapter.isUploadedSponsorCompanyLetter()){
						dataMap.put(templatVarName, sponsorCompany);
					}else{
						dataMap.put(templatVarName, NOT_APPLICABLE);
					}
				}
				else if ("isUploadedIdentityDoc".equalsIgnoreCase(fieldId)){
					dataMap.put(templatVarName, dataAdapter.getYesorNo(dataAdapter.isUploadedIdentityDoc()));
				}else if ("isUploadedHighestQualificationCertificate".equalsIgnoreCase(fieldId)){
					dataMap.put(templatVarName, dataAdapter.getYesorNo(dataAdapter.isUploadedHighestQualificationCertificate()));
				}else if ("isUploadedResume".equalsIgnoreCase(fieldId)){
					boolean uploaded = dataAdapter.isUploadedResume();
					boolean  linkedIn = Validator.isNotNull(dataAdapter.getLinkedInProfile());
					if(uploaded || linkedIn){
						dataMap.put(templatVarName, dataAdapter.getYesorNo(true));
					}else{
						dataMap.put(templatVarName, dataAdapter.getYesorNo(false));
					}
				}else if ("isUploadedRecentPhoto".equalsIgnoreCase(fieldId)){
					dataMap.put(templatVarName, dataAdapter.getYesorNo(dataAdapter.isUploadedRecentPhoto()));
				}else if ("isUPloadedSponsorLetter".equalsIgnoreCase(fieldId)){
					String catId = SambaashUtil.getParameter(PEConstants.SP_PARAM_SELF_SPONSORED_CATEGORY_ID, 0);
					if (dataAdapter.getSponseredBy() == GetterUtil.getLong(catId)){
						dataMap.put(templatVarName, "No");
					}else{
						dataMap.put(templatVarName, dataAdapter.getYesorNo(dataAdapter.isUploadedSponsorCompanyLetter()));
					}
				}else if("studentOrGaurdianName".equalsIgnoreCase(fieldId)){
					if(dataAdapter.isStudentMinor()){
						dataMap.put(templatVarName, dataAdapter.getGaurdIanFullName());
					}else{
						dataMap.put(templatVarName, fullNameApplicant);
					}
				}else if("studentOrGaurdianIdentityDocNum".equalsIgnoreCase(fieldId)){
					if(dataAdapter.isStudentMinor()){
						dataMap.put(templatVarName, dataAdapter.getGaurdIanIdentityDocNum());
					}else{
						dataMap.put(templatVarName, dataAdapter.getStudentIdentityDocNum());
					}
				}else if("wardName".equalsIgnoreCase(fieldId)){
					if(dataAdapter.isStudentMinor()){
						dataMap.put(templatVarName, fullNameApplicant);
					}else{
						dataMap.put(templatVarName, "");
					}
				}else if("wardDocuIdentityNum".equalsIgnoreCase(fieldId)){
					if(dataAdapter.isStudentMinor()){
						dataMap.put(templatVarName, dataAdapter.getStudentIdentityDocNum());
					}else{
						dataMap.put(templatVarName, "");
					}
				}else if("studentNRICNum".equalsIgnoreCase(fieldId)){
					String nricNum = dataAdapter.getStudentNricNum();
					if(Validator.isNotNull(nricNum)){
						dataMap.put(templatVarName, nricNum);
					}else{
						dataMap.put(templatVarName, NOT_APPLICABLE);
					}
				}else if("studentPassportNum".equalsIgnoreCase(fieldId)){
					String passportNum = dataAdapter.getStudentPassportNum();
					if(Validator.isNotNull(passportNum)){
						dataMap.put(templatVarName, passportNum);
					}else{
						dataMap.put(templatVarName, NOT_APPLICABLE);
					}
				}else if("currentDate".equalsIgnoreCase(fieldId)){
					dataMap.put(templatVarName, PEHelper.getDateStrddMMYYYY(DateUtil.newDate()));
				}else if("currentDateInStudentSignature".equalsIgnoreCase(fieldId)){
					if(dataAdapter.isStudentMinor()){
					dataMap.put(templatVarName, NOT_APPLICABLE);
					}
				}else if("currentDateInParentSignature".equalsIgnoreCase(fieldId)){
					if(!dataAdapter.isStudentMinor()){
					dataMap.put(templatVarName, NOT_APPLICABLE);
					}
				}
				else if("parentNameSignature".equalsIgnoreCase(fieldId)){
					if(!dataAdapter.isStudentMinor()){
						dataMap.put(templatVarName, NOT_APPLICABLE);
					}
				}
				else if("studentNameSignature".equalsIgnoreCase(fieldId)){
					if(dataAdapter.isStudentMinor()){
						dataMap.put(templatVarName, NOT_APPLICABLE);
					}
				}
				else if("studiesCommencementDate".equalsIgnoreCase(fieldId)){
					try {
						Date date1 = dataAdapter.getStudeisCommencementDate();
						Date date2 = dataAdapter.getCourseCommencementDate();
						if(Validator.isNotNull(date1) && Validator.isNotNull(date2) && date1.compareTo(date2) == 0){
							dataMap.put(templatVarName, NOT_APPLICABLE);
						}else if (Validator.isNull(date1)){
							dataMap.put(templatVarName, NOT_APPLICABLE);	
						}else{
							dataMap.put(templatVarName, PEHelper.getDateStrddMMYYYY(date1));
						}
					} catch (Exception e) {
						_log.error("Error while comparing studies commencemant and course commencement dates",e);
					}
				} // there are few check box fields,whose value must be displayed as yes/no in contract ( Singapore Qualification Course applicaiton 
				else if("admisiionEnrollment".equals(fieldId) || "courseDetails".equals(fieldId) || "courseCounselling".equals(fieldId) 
						|| "contractDetails".equals(fieldId) || "trainingInfo".equals(fieldId) || "studentPassHolder".equals(fieldId) || "readFees".equals(fieldId)){
					String value = dataAdapter.getFieldSimpleValue(fieldId);
					if(value.length() > 0){
						dataMap.put(templatVarName, "Yes");
					}else{
						dataMap.put(templatVarName, "No");
					}
				}
				else if("gaurdianFullNameConditionalWithContact".equalsIgnoreCase(fieldId)){
					 if(dataAdapter.isStudentMinor()){
						 dataMap.put(templatVarName, dataAdapter.getGaurdIanFullName()+" , "+dataAdapter.getGaurdIanContactNumber()+" , "+dataAdapter.getGuardianEmail());
					 }else{
						 dataMap.put(templatVarName, NOT_APPLICABLE);
					 }
				 }
			}
		}	
	
		return dataMap;
	}
	
	private String getValueNullSafe(Cell cell){
		String value = StringPool.BLANK;
		if(cell != null){
			value = cell.getStringCellValue();
		}
		return value;
	}
	
	private String generateContract(Map<String,String>dataMap,InputStream templateInStream,String filePrefix) throws PEException{
		try {
			PDDocument pdDoc = PDDocument.load(templateInStream);
			PDDocumentCatalog pdCatalog = pdDoc.getDocumentCatalog();
			PDAcroForm acroForm = pdCatalog.getAcroForm();
			List<PDField> fields = acroForm.getFields();
			for (PDField field : fields) {
				if(field != null){
					String fieldName = GetterUtil.getString(field.getFullyQualifiedName());
					
					if(fieldName.toLowerCase().startsWith("to the school to use my personal data") ||  fieldName.startsWith("CHECK_BOX_YES")){
						// it's a prechecked checkbox in template. so dont set any value to it. just proceed
						continue;
					}
					field.setValue(GetterUtil.getString(dataMap.get(fieldName)));
					field.setReadOnly(true);
				}
			}
			
			/*COSDictionary acroFormDict = acroForm.getDictionary();
			COSArray cosFields = (COSArray) acroFormDict.getDictionaryObject("Fields");
			cosFields.clear();
			*/
			/*AccessPermission access = pdDoc.getCurrentAccessPermission();
		//	access.setCanAssembleDocument(false);
		//	access.setCanExtractContent(false);
		////	access.setCanModifyAnnotations(false);
		//	access.setCanFillInForm(false);
			//access.setCanModify(false);
		//	access.setCanPrint(true);
		//	access.setReadOnly();
			StandardProtectionPolicy p = new StandardProtectionPolicy("", "", access);
		//	pdDoc.protect(p);*/
			String filePath = getFilePath(filePrefix);
			OutputStream os = new FileOutputStream(filePath);
			pdDoc.save(os);
		//	pdDoc.save(new File(filePath));
			_log.debug("Contract saved to temp directory. Path:" + filePath);
			os.flush();
			os.close();
			pdDoc.close();
			return filePath;
		} catch (IOException   e) {
			_log.error(e);
			throw new PEException("Error while generating the contract");
		}
	}

	public String getFilePath(String prefix) {
		String fileName = prefix + dataSource.getApplicant().getUserId() + "_" + System.currentTimeMillis() +".pdf";
		StringBundler sb = new StringBundler(5);

		sb.append(SystemProperties.get(SystemProperties.TMP_DIR));
		sb.append("/liferay/");
		sb.append(fileName);
		
		return sb.toString();
	}
	
	
	public static Workbook getWorkBook(String extension,InputStream inputStream) throws PEException{
		Workbook wb;
		try {
			if(!extension.startsWith(".")){
				extension = "." + extension;
			}
			if (extension.endsWith(EXCEL.EXTENSION)) {
				wb = readFileXlsx(inputStream);
			} else if (extension.endsWith(EXCEL.EXTENSION_OLD)) {
				wb = readFileXls(inputStream);
			} else {
				throw new FileFormatException(FileFormatException.FILE_TYPE_EXCEPTION);
			}
		} catch (IOException | FileFormatException e) {
			throw new PEException(PEErrors.SYSTEM_ERROR);
		}
		return wb;
	}
	
	public static HSSFWorkbook readFileXls(InputStream inputStream)
			throws IOException {
		return new HSSFWorkbook(inputStream);
	}

	public static XSSFWorkbook readFileXlsx(InputStream inputStream)
			throws IOException {
		return new XSSFWorkbook(inputStream);
	}

	private static final Log _log = LogFactoryUtil.getLog(CourseEnrollContractHelper.class);
}
