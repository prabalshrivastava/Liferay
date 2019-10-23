package com.sambaash.platform.pe.error;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.pe.PEError;
public class PEErrors {

	public static final String SYSTEM_ERROR_MSG = "Error while processing your request. Please contact support team";
	 
	public static final PEError TEMP_STORAGE_VALIDATION_ERROR = new PEError("You are not allowed to take course",500l);
	
	public static final PEError ACCOUNT_CREATION_EMAIL_ERROR_ARGS = new PEError("Error while creating account.Invalid EmailAdress %s",504l);

	public static final PEError ACCOUNT_CREATION_ERROR = new PEError("Error while creating account.",503l);

	public static final PEError AUDIT_ACCOUNT = new PEError(SYSTEM_ERROR_MSG,"Error while auditing account creation",2005l);

	public static final PEError AUDIT_FORM = new PEError(SYSTEM_ERROR_MSG,"Error while auditing form",2000l);

	public static final PEError AUDIT_JSP = new PEError(SYSTEM_ERROR_MSG,"Error while auditing jsp submission",2010l);

	public static final PEError AUDIT_PAYMENT = new PEError(SYSTEM_ERROR_MSG,"Error while auditing payment submission",3010l);
	
	public static final PEError AUDIT_PREVIEW = new PEError(SYSTEM_ERROR_MSG,"Error while previewing file",3020l);

	public static final PEError AUDIT_PAYMENT_V2 = new PEError(SYSTEM_ERROR_MSG,"Error while auditing payment v2 submission",3011l);

	public static final PEError AUDIT_PRICING = new PEError(SYSTEM_ERROR_MSG,"Error while auditing pricing submission",3030l);

	public static final PEError AUDIT_NEAREST_FORM_JSP_NOT_FOUND_ARGS = new PEError(SYSTEM_ERROR_MSG,"Not able to find form/jsp corresponding to selected status. Status Type=%s, Process State Id = %s",2006l);

	public static final PEError AUDIT_NOT_FOUND_STATUS_TYPE_ARGS = new PEError(SYSTEM_ERROR_MSG,"Audit record not found. Status Type=%s",2021l);

	public static final PEError AUDIT_PROCESS_ARGS = new PEError(SYSTEM_ERROR_MSG,"Error while auditing process node execution %s",2015l);

	public static final PEError AUDIT_STATUS = new PEError(SYSTEM_ERROR_MSG,"Error while auditing status change",2020l);

	public static final PEError CONFIG_ERROR_PROCESS_DEFINITON = new PEError(SYSTEM_ERROR_MSG,"Process definition configuration error",305l);

	public static final PEError CONFIG_ERROR_STATUS_ZERO = new PEError(SYSTEM_ERROR_MSG,"Configuration error. Status is 0",300l);

	public static final PEError CONIG_ERROR_PROCESS_STATE_LISTING_PAGE = new PEError(SYSTEM_ERROR_MSG,"Configuration Error. Process Id is empty",102l);

	public static final PEError CONIG_ERROR_REGISTER_PAGE = new PEError("Configuration Error.Either Process Id or Entity Id is 0. Please contact support team",101l);

	public static final PEError DISPLAYABLE_NOT_FOUND = new PEError(SYSTEM_ERROR_MSG,"Action found instead of displayable object",115l);

	public static final PEError FORM_NOT_FOUND_ARGS = new PEError(SYSTEM_ERROR_MSG,"Form not found. RulesetId = %s, Form = %s",502l);
	
	public static final PEError RULESET_NOT_FOUND_ARGS = new PEError(SYSTEM_ERROR_MSG,"Ruleset not found. RulesetId = %s",503l);

	public static final PEError JSP_PATH_NOT_FOUND = new PEError(SYSTEM_ERROR_MSG,"JSP path not found.",501l);

	public static final PEError LATEST_STATUS_TYPE_MISMATCH = new PEError("You are tying to Approve old record","Approval can be done for latest process status",107l);

	public static final PEError NEXT_STEP_NOT_FOUND = new PEError(SYSTEM_ERROR_MSG,"Not able to find next possible step",110l);

	public static final PEError NO_OUTPUT = new PEError("Unable to proceed",200l);

	public static final PEError NODE_NOT_FOUND = new PEError(SYSTEM_ERROR_MSG,"Not able to find the node in process",125l);

	public static final PEError NOT_FOUND_MAIL_TEMPLATE_ARGS = new PEError("Error while sending mail","Mail template not found. Template Id =%s",505l);

	public static final PEError PROCESS_DEF_PARSE_ERROR = new PEError(SYSTEM_ERROR_MSG,"Process Definiton can not parsed",99l);

	public static final PEError PROCESS_DEFINITON_NOT_FOUND = new PEError(SYSTEM_ERROR_MSG,"Process definition not found",310l);

	public static final PEError PROCESS_STATE_MISSKING_PK_FIELD_ARGS = new PEError("Invalid Process State. One or more PK fields in Process State are 0 : %s",105l);

	public static final PEError PROCESS_STATE_NOT_FOUND_ARGS = new PEError("Not able find application","Process State not found.Process State Id = %s",106l);

	public static final PEError PROCESS_STATE_NULL = new PEError("Process state is not valid",108l);

	public static final PEError RECEIVED_NODE_NOT_VALID = new PEError("Invalid form submission","NodeId receivd from user is not valid",120l);

	public static final PEError RULE_SET_NOT_FOUND = new PEError(SYSTEM_ERROR_MSG,"Rule set not found",400l);

	public static final PEError RULE_SET_NOT_FOUND_ARGS = new PEError(SYSTEM_ERROR_MSG,"Rule set not found. Ruleset Id=%s",401l);

	public static final PEError RULE_SET_NOT_VALID_FOR_COMPONENT = new PEError(SYSTEM_ERROR_MSG,"Rule set not valid for this component type. Ruleset Id=%s",410l);

	public static final PEError ERROR_WHILE_RETRIVING = new PEError(SYSTEM_ERROR_MSG,"Error while retriving the data",402l);

	public static final PEError STATUS_TYPE_NOT_FOUND = new PEError("Not able to find the step","Status Type not found",10l);

	public static final PEError STATUS_TYPE_NOT_FOUND_ARGS = new PEError("Status Type not found. Status Type=%s",102);

	public static final PEError STATUS_TYPE_NOT_TRAVERSED = new PEError("Status Type not yet traversed",103);

	public static final PEError SYSTEM_ERROR = new PEError("System Error. Please contact admin.",500l);
	
	public static final PEError USER_EXITS_EMAIL_ADDRESS = new PEError("Account exists with provided email address.Plese login.",1000l);

	public static final PEError USER_PROCESS_STATE_NOT_VALID = new PEError("User process state is not valid",100l);

	public static final PEError UNAUTHORIZED_USER = new PEError("You are not authorized to view this page",2001l);
	public static final PEError INVALID_STATUS_CHANGE_TO_APPROVED = new PEError("You are trying to Approve the application which is already Approved/Rejected.",2010l);
	public static final PEError INVALID_STATUS_CHANGE_TO_REJECT = new PEError("You are trying to Reject the application which is already Approved/Rejected.",2020l);
	public static final PEError UNAUTHORIZED_REJECT = new PEError("You are not authorized to Reject the applicaiton",2030l);
	public static final PEError UNAUTHORIZED_APPROVE = new PEError("You are not authorized to Approve the application",2040l);
	public static final PEError UNSUPPORTED_DEVICE = new PEError("You are trying to view the page from unsupported device.",2050l);
	public static final PEError UNAUTHORIZED_FORM_SUBMIT = new PEError("You are not authorized to submit the data.",2060l);
	public static final PEError UNABLE_TO_GET_LOCK = new PEError("Please try after some time. ",2070l);
	public static final PEError ENTITY_NOT_FOUND_ARGS  = new PEError("Entity not found. Entity Id =%s",2080l);

	
	public static final PEError ESIGN_CONTRACT_TEMPLATE_INFO_NOT_FOUND_ARGS = new PEError("Contract template info not found. Country Id = %s and Course Type=%s",3005);
	public static final PEError ESIGN_CONTRACT_TEMPLATE_NOT_FOUND_ARGS = new PEError("Contract template  not found. Template file entry id = %s",3010);
	public static final PEError ESIGN_DATA_TEMPLATE_NOT_FOUND_ARGS = new PEError("Data template  not found. Template file entry id = %s",3015);

	public static final PEError REQUEST_DATA_ERROR = new PEError("Error while preparing request data",4000);
	public static final PEError DATE_FORMAT_ERROR = new PEError("Error while parsing date",4010);
	public static final PEError APPLICATION_CLOSED = new PEError("Application Closed",4020);

	public static final PEError CUSTOM_ACTION_CLASS_NOT_FOUND = new PEError("Configuration Error.",4030);
	
	public static final PEError FORM_SAVE_ERROR = new PEError("Error while saving the form",4040);
	public static final PEError FORM_SAVE_ERROR_DATA_INVALID = new PEError("Invalid data submitted from form",4050);
	public static final PEError FORM_JSP_SAVE_ERROR_UNAUTHORIZED = new PEError("You are not authorized to modify the details.",4060);
	public static final PEError JSP_SAVE_ERROR_NO_HANDLER = new PEError("Unable to save","Unable to find JSP save handler",4070);
	public static final PEError INVALID_STATUS_ENTITY_ID = new PEError("Entity Id is not valid.",4080l);	
	
	

	public static PEError format(PEError perror, Object ...args) {
		if (Validator.isNull(perror)) {
			return null;
		}

		PEError cloned = perror.clone();
		try {
			cloned.setMsg(String.format(cloned.getMsg(), args));
			cloned.setMsgDesc(String.format(cloned.getMsg(), args));
		} catch (Exception e) {
			_log.error(e);
		}

		return cloned;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(PEErrors.class);
}