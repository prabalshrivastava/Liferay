package com.sambaash.platform.portlet.datapatcing.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SambaashConstants.EXCEL;
import com.sambaash.platform.exception.FileFormatException;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class PreCourseCounsellingBatchUpdateHelper {

	private PortletRequest request;
	private List<String> errors = new ArrayList<String>();
	private List<String> msgs = new ArrayList<String>();

	public PreCourseCounsellingBatchUpdateHelper(PortletRequest request) {
		this.request = request;

	}

	public void bulkupdate() throws FileNotFoundException, IOException,
			FileFormatException {

		List<PEProcessAudit> peProcessAuditList;
		PEProcessAudit peProcessAudit = null;
		try {
			
		String formId = SambaashUtil.getParameter("pre.course.counselling.formId", SambaashConstants.DEFAULT_GROUP_ID_LONG);
		peProcessAuditList = PEProcessAuditLocalServiceUtil.findByActionTypeField2("submit", "form", formId);
		
		if (peProcessAuditList.size() > 0){
			for (int i = 0; i < peProcessAuditList.size(); i++){
				peProcessAudit = peProcessAuditList.get(i);
				
				if (!errorsExists){
				String data = peProcessAudit.getData1();
				JSONObject dataJson = JSONFactoryUtil.createJSONObject(data);
				
				String content = dataJson.getString("content");
				JSONObject contentJson = JSONFactoryUtil.createJSONObject(content);
				JSONArray stepArr = contentJson.getJSONArray("step1");
				
				for (int j = 0; j < stepArr.length(); j++) {
					JSONObject row = stepArr.getJSONObject(j);
					
					String fieldName = "";
	                String value = "";
	                
	                fieldName = row.getString("id");
	                if(row.has("options")) {
                        JSONArray optionArray = row.getJSONArray("options");
                        if (optionArray.length() > 0){
                        JSONObject option = optionArray.getJSONObject(0);
                        value = option.getString("value");

                        if (fieldName.equalsIgnoreCase("admission_and_enrolment_2")) {
                            row.put("id", "admission_2");
                            if (!value.isEmpty()) {
                                option.put("value", "Application procedure, Admission requirement, Module exemption if any.");
                            } else {
                                option.put("value", "");
                            }
                        } else if (fieldName.equalsIgnoreCase("contract_details_3")) {
                            row.put("id", "policies_3");
                            if (!value.isEmpty()) {
                                option.put("value", "Refund, Withdrawal, Deferment, FPS(for non-FPS waiver course candidate only).");
                            } else {
                                option.put("value", "");
                            }

                            JSONObject jsonFees = JSONFactoryUtil.createJSONObject();
                            jsonFees.put("id", "fees_4");

                            JSONArray jsonFeesOptionsArray =  JSONFactoryUtil.createJSONArray();
                            JSONObject valueObj = JSONFactoryUtil.createJSONObject();
                            if (!value.isEmpty()) {
                                valueObj.put("value", "Payable fee, Payment method throughout the course duration, Miscellaneous fee (when applicable).");
                            } else {
                                valueObj.put("value", "");
                            }
                            jsonFeesOptionsArray.put(valueObj);
                            jsonFees.put("options", jsonFeesOptionsArray);

                            stepArr.put(jsonFees);

                        } else if (fieldName.equalsIgnoreCase("course_details_4")) {
                            if (!value.isEmpty()) {
                                option.put("value", "Course Modules, Outlines, Duration, Assessment criteria & schedule, Type of award.");
                            } else {
                                option.put("value", "");
                            }
                        } else if (fieldName.equalsIgnoreCase("course_counselling_4")) {
                            if (!value.isEmpty()) {
                                option.put("value", "Course learning outcome, Job prospect after graduation, Education pathway.");
                            } else {
                                option.put("value", "");
                            }
                        } else if (fieldName.equalsIgnoreCase("training_provider_support_6")) {
                            row.put("id", "student_support_services_6");
                            if (!value.isEmpty()) {
                                option.put("value", "Campus Facilities, Learning support, Career Services etc.");
                            } else {
                                option.put("value", "");
                            }
                        } else if (fieldName.contains("pass_holder")) {
                            row.put("id", "for_student’s_pass_holder_only_7");
                            if (!value.isEmpty()) {
                                option.put("value", "Student are not permitted to engage in any form of employment or attend an industrial/internship program, whether paid or unpaid, without a valid work pass issued by MOM.Student’s pass application requirements and procedures.");
                            } else {
                                option.put("value", "");
                            }
                        }
	                }
	                }
				}
				
				
				contentJson.put("step1", stepArr);
				peProcessAudit.setData1(dataJson.put("content", contentJson.toString()).toString());
				PEProcessAuditLocalServiceUtil.updatePEProcessAudit(peProcessAudit);
				bulkupdateProcessState(peProcessAudit.getSpPEProcessStateId());
				
				
				
				addMsg("Update success", peProcessAudit.getSpPEProcessAuditId());
			}
			}
		}
		
		} catch (NoSuchPEProcessAuditException | SystemException | JSONException e) {
			_log.error(e);
			addError("Update failed", peProcessAudit.getSpPEProcessAuditId());
		}

	}
	
	
	public void bulkupdateProcessState(long spPeProcessStateeId)
			throws FileNotFoundException, IOException, FileFormatException {

		PEProcessState peProcessState;
		try {

			peProcessState = PEProcessStateLocalServiceUtil
					.getPEProcessState(spPeProcessStateeId);

			if (!errorsExists) {
				String data = peProcessState.getData();
				JSONObject dataJson = JSONFactoryUtil.createJSONObject(data);

				String key = null;
				JSONArray valueArr = null;
				String value = null;

				// to replace courseCounselling data
				key = dataJson.getString("courseCounselling");
				if (Validator.isNotNull(key)) {
					valueArr = JSONFactoryUtil.createJSONArray(key);
					if (valueArr.length() > 0) {
						JSONObject option = valueArr.getJSONObject(0);
						value = option.getString("value");
						if (!value.isEmpty()) {
							option.put("value","Course learning outcome, Job prospect after graduation, Education pathway.");
						} else {
							option.put("value", "");
						}

					}
					dataJson.put("courseCounselling", valueArr.toString()).toString();
				}

				// to replace contractDetails data
				key = dataJson.getString("contractDetails");
				if (Validator.isNotNull(key)) {
					valueArr = JSONFactoryUtil.createJSONArray(key);
					if (valueArr.length() > 0) {
						JSONObject option = valueArr.getJSONObject(0);
						value = option.getString("value");
						if (!value.isEmpty()) {
							option.put("value","Refund, Withdrawal, Deferment, FPS(for non-FPS waiver course candidate only).");
						} else {
							option.put("value", "");
						}

					}
					dataJson.put("contractDetails", valueArr.toString()).toString();

					JSONArray jsonFeesOptionsArray = JSONFactoryUtil
							.createJSONArray();
					JSONObject valueObj = JSONFactoryUtil.createJSONObject();
					if (!value.isEmpty()) {
						valueObj.put(
								"value","Payable fee, Payment method throughout the course duration, Miscellaneous fee (when applicable).");
					} else {
						valueObj.put("value", "");
					}
					jsonFeesOptionsArray.put(valueObj);
					dataJson.put("readFees", jsonFeesOptionsArray.toString()).toString();
				}
				
				// to replace admission data
				key = dataJson.getString("admisiionEnrollment");
				if (Validator.isNotNull(key)) {
					valueArr = JSONFactoryUtil.createJSONArray(key);
					if (valueArr.length() > 0) {
						JSONObject option = valueArr.getJSONObject(0);
						value = option.getString("value");
						if (!value.isEmpty()) {
							option.put("value","Application procedure, Admission requirement, Module exemption if any.");
						} else {
							option.put("value", "");
						}

					}
					dataJson.put("admisiionEnrollment", valueArr.toString()).toString();
				}
				
				// to replace courseDetails data
				key = dataJson.getString("courseDetails");
				if (Validator.isNotNull(key)) {
					valueArr = JSONFactoryUtil.createJSONArray(key);
					if (valueArr.length() > 0) {
						JSONObject option = valueArr.getJSONObject(0);
						value = option.getString("value");
						if (!value.isEmpty()) {
							option.put("value","Course Modules, Outlines, Duration, Assessment criteria & schedule, Type of award.");
						} else {
							option.put("value", "");
						}

					}
					dataJson.put("courseDetails", valueArr.toString()).toString();
				}
				
				// to replace trainingInfo data
				key = dataJson.getString("trainingInfo");
				if (Validator.isNotNull(key)) {
					valueArr = JSONFactoryUtil.createJSONArray(key);
					if (valueArr.length() > 0) {
						JSONObject option = valueArr.getJSONObject(0);
						value = option.getString("value");
						if (!value.isEmpty()) {
							option.put("value","Campus Facilities, Learning support, Career Services etc.");
						} else {
							option.put("value", "");
						}

					}
					dataJson.put("trainingInfo", valueArr.toString()).toString();
				}
				
				
				// to replace studentPassHolder data
				key = dataJson.getString("studentPassHolder");
				if (Validator.isNotNull(key)) {
					valueArr = JSONFactoryUtil.createJSONArray(key);
					if (valueArr.length() > 0) {
						JSONObject option = valueArr.getJSONObject(0);
						value = option.getString("value");
						if (!value.isEmpty()) {
							option.put("value","Student are not permitted to engage in any form of employment or attend an industrial/internship program, whether paid or unpaid, without a valid work pass issued by MOM.Student’s pass application requirements and procedures.");
						} else {
							option.put("value", "");
						}

					}
					dataJson.put("studentPassHolder", valueArr.toString()).toString();
				}

				peProcessState.setData(dataJson.toString());
				PEProcessStateLocalServiceUtil.updatePEProcessState(peProcessState);

			}

		} catch (SystemException | PortalException e) {
			_log.error(e);
			addError("Update failed", spPeProcessStateeId);
		}

	}

	boolean errorsExists = false;

	private void addError(String msg, long auditRecordNumber) {
		errorsExists = true;
		getErrors().add("SPPEProcessAuditId No = " + auditRecordNumber + "  " + msg);
	}

	private void addMsg(String msg, long auditRecordNumber) {
		getMsgs().add("SPPEProcessAuditId No = " + auditRecordNumber + "  " + msg);
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
			.getLog(PreCourseCounsellingBatchUpdateHelper.class);
}
